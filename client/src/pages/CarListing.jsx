import React, { useEffect, useState } from "react";
import { Container, Row, Col } from "reactstrap";
import Helmet from "../components/Helmet/Helmet";
import CommonSection from "../components/UI/CommonSection";
import CarItem from "../components/UI/CarItem";

const CarListing = () => {
  const [carData, setCarData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchCarData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/v1/cars");
        if (response.ok) {
          const data = await response.json();
          setCarData(data);
        } else {
          console.error("Error fetching car data. Status:", response.status);
        }
      } catch (error) {
        console.error("Error fetching car data:", error);
      } finally {
        setLoading(false);
      }
    };

    fetchCarData();
  }, []);

  return (
    <Helmet title="Cars">
      <CommonSection title="Car Listing" />

      <section>
        <Container>
          <Row>
            <Col lg="12">
              <div className="d-flex align-items-center gap-3 mb-5">
                <span className="d-flex align-items-center gap-2">
                  <i className="ri-sort-asc"></i> Sort By
                </span>

                <select>
                  <option>Select</option>
                  <option value="low">Low to High</option>
                  <option value="high">High to Low</option>
                </select>
              </div>
            </Col>

            {loading ? (
              <p>Loading...</p>
            ) : (
              carData.map((item) => <CarItem item={item} key={item.id} />)
            )}
          </Row>
        </Container>
      </section>
    </Helmet>
  );
};

export default CarListing;
