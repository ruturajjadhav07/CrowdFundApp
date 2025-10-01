import React, { useState } from "react";
import { Link, useLocation } from "react-router-dom";

const Navbar = () => {
  const location = useLocation();
  const isLoginPage = location.pathname === "/login";

  // State to toggle collapse on small screens
  const [isCollapsed, setIsCollapsed] = useState(true);

  // Toggle navbar collapse state
  const toggleNavbar = () => {
    setIsCollapsed(!isCollapsed);
  };

  return (
    <nav
      className="navbar navbar-expand-lg navbar-light"
      style={{
        position: "fixed",
        top: 0,
        left: 0,
        width: "100%",
        backdropFilter: "blur(8px)",
        backgroundColor: "rgba(250, 250, 250, 0.25)",
        zIndex: 10,
        padding: "0.5rem 1rem",
        borderBottom: "1px solid rgba(0, 0, 0, 0.08)",
        boxShadow: "0 2px 8px rgba(0, 0, 0, 0.05)",
      }}
    >
      <div className="container-fluid">
        {/* Brand */}
        <Link
          to="/"
          className="navbar-brand"
          style={{
            color: "#0A192F",
            fontSize: "24px",
            fontWeight: "bold",
            letterSpacing: "0.5px",
            textDecoration: "none",
          }}
        >
          CrowdFund
        </Link>

        {/* Toggler Button */}
        <button
          className="navbar-toggler"
          type="button"
          onClick={toggleNavbar}
          aria-controls="navbarNav"
          aria-expanded={!isCollapsed}
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        {/* Collapsible Menu */}
        <div
          className={`collapse navbar-collapse ${!isCollapsed ? "show" : ""}`}
          id="navbarNav"
        >
          <ul className="navbar-nav ms-auto gap-3">
            <li className="nav-item">
              <Link
                to="/"
                className="nav-link"
                style={linkStyle}
                onMouseEnter={handleMouseEnter}
                onMouseLeave={handleMouseLeave}
                onClick={() => setIsCollapsed(true)} // close menu after click
              >
                Home
              </Link>
            </li>

            <li className="nav-item">
              <a
                href="#about"
                className="nav-link"
                style={linkStyle}
                onMouseEnter={handleMouseEnter}
                onMouseLeave={handleMouseLeave}
                onClick={() => setIsCollapsed(true)}
              >
                About
              </a>
            </li>

            <li className="nav-item">
              <a
                href="#contact"
                className="nav-link"
                style={linkStyle}
                onMouseEnter={handleMouseEnter}
                onMouseLeave={handleMouseLeave}
                onClick={() => setIsCollapsed(true)}
              >
                Contact Us
              </a>
            </li>

            {!isLoginPage && (
              <li className="nav-item">
                <Link
                  to="/login"
                  className="nav-link"
                  style={linkStyle}
                  onMouseEnter={handleMouseEnter}
                  onMouseLeave={handleMouseLeave}
                  onClick={() => setIsCollapsed(true)}
                >
                  Login
                </Link>
              </li>
            )}
          </ul>
        </div>
      </div>
    </nav>
  );
};

const linkStyle = {
  color: "#112D4E",
  fontSize: "16px",
  fontWeight: "500",
  transition: "color 0.3s, borderBottom 0.3s",
  paddingBottom: "2px",
  borderBottom: "2px solid transparent",
  textDecoration: "none",
};

const handleMouseEnter = (e) => {
  e.target.style.color = "#F9A826";
  e.target.style.borderBottom = "2px solid #F9A826";
};

const handleMouseLeave = (e) => {
  e.target.style.color = "#112D4E";
  e.target.style.borderBottom = "2px solid transparent";
};

export default Navbar;
