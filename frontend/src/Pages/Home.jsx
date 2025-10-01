import assets from "../assets/photo1.avif";
import Navbar from "../Components/Navbar";
import About from "./about";

const Home = () => {
  return (
    <div>
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
        <div
          id="home"
          style={{
            position: "absolute",
            top: "50%",
            left: "50%",
            transform: "translate(-50%, -50%)",
            color: "white",
            fontSize: "8rem",
            fontWeight: "bold",
            opacity: 0.6,
            textShadow: "2px 2px 5px rgba(0, 0, 0, 0.7)",
            whiteSpace: "nowrap",
          }}
        >
          Together, we rise.
        </div>
      </div>
      <About />
    </div>
  );
};

export default Home;
