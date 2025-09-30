import React from "react";
import assets from "../assets/photo1.avif";
import Navbar from "../Components/Navbar";

const Home = () => {
  return (
    <div style={{ position: "relative", height: "100vh", width: "100%" }}>
      <Navbar /> {/* This will appear on top of the image */}
      <img
        src={assets}
        alt="handshake"
        style={{
          objectFit: "cover",
          objectPosition: "center",
          width: "100%",
          height: "100vh",
        }}
      />
    </div>
  );
};

export default Home;
