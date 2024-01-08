import React from "react"
 
function DefaultLayout(props){
    return(
        <div>
            <div className="header">
                <div className="d-flex justify-content-center">
                     <h1> Renting Cars </h1>
                </div>

            </div>
            <div className="content">
                {props.children}
        </div>
        </div>
        
    )
 }
 export default DefaultLayout