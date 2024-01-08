import React from "react";
import { Container, Row, Col } from "reactstrap";
import "../../styles/about-section.css";
import aboutImg from "../../assets/all-images/cars-img/bmw-offer.png";

const AboutSection = ({ aboutClass }) => {
  return (
    <section
      className="about__section"
      style={
        aboutClass === "aboutPage"
          ? { marginTop: "0px" }
          : { marginTop: "280px" }
      }
    >
      <Container>
        <Row>
          <Col lg="6" md="6">
            <div className="about__section-content">
              <h4 className="section__subtitle">About Us</h4>
              <h2 className="section__title">Welcome to car rent service</h2>
              <p className="section__description">
              we believe in more than just providing cars; we are dedicated to delivering an
              unparalleled experience that goes beyond transportation. Established with a
               passion for quality service and a commitment to customer satisfaction,
              we take pride in being your trusted partner for all your car rental needs.
              </p>

              <div className="about__section-item d-flex align-items-center">
                <h4 className="section_subtitle">Our Mission</h4>
                <p className="section_description">
                Our mission is to redefine the car rental experience 
                by offering a diverse fleet of well-maintained vehicles, coupled with exceptional customer service. We strive to make your journey memorable,
                 whether it's a quick business trip, a family vacation, or a special occasion.
                </p>
              </div>

              <div className="about__section-item d-flex align-items-center">
                <h4 className="section_subtitle">Why Choose Us</h4>
                <p className="section__description">
  <ul>
    <li><strong>Quality Fleet:</strong> Our extensive fleet comprises the latest models, meticulously maintained to ensure safety and comfort.</li>

    <li><strong>Customer-Centric Approach:</strong> We prioritize your needs, providing personalized service to make your rental experience smooth and enjoyable.</li>

    <li><strong>Transparent Pricing:</strong> No hidden costs. Our transparent pricing policy ensures you know exactly what you're paying for, with no surprises.</li>

    <li><strong>Convenience:</strong> From online reservations to flexible pickup and drop-off options, we make renting a car convenient and hassle-free.</li>
  </ul>
</p>

              </div>
            </div>
          </Col>

          <Col lg="6" md="6">
            <div className="about__img">
              <img src={aboutImg} alt="" className="w-100" />
            </div>
          </Col>
        </Row>
      </Container>
    </section>
  );
};

export default AboutSection;