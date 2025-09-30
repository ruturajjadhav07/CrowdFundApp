import React, { useState } from "react";
import Navbar from "./Navbar";
const Login = () => {
  const [isCreatedAccount, setIsCreatedAccount] = useState(false);
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);

  // submit handler
  const handleSubmit = (e) => {
    e.preventDefault();
    setLoading(true);
    console.log(username, email, password);
  };

  return (
    <div>
      <Navbar/>
      <div className="d-flex justify-content-center align-items-center min-vh-100 bg-light">
        <div
          className="card p-4 shadow"
          style={{ maxWidth: "400px", width: "100%" }}
        >
          <h2 className="text-center mb-4">
            {isCreatedAccount ? "Create Account" : "Login"}
          </h2>
          <form onSubmit={handleSubmit}>
            {isCreatedAccount && (
              <div className="mb-3">
                <label className="form-label">Username</label>
                <input
                  type="text"
                  placeholder="username"
                  className="form-control"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  required
                />
              </div>
            )}
            <div className="mb-3">
              <label className="form-label">Email</label>
              <input
                type="email"
                placeholder="example@gmail.com"
                className="form-control"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>

            <div className="mb-3">
              <label className="form-label">Password</label>
              <input
                type="password"
                placeholder="********"
                className="form-control"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>

            <button
              type="submit"
              className="btn btn-primary w-100 mb-2"
              disabled={loading}
            >
              {loading
                ? "Loading"
                : isCreatedAccount
                ? "Create Account"
                : "Login"}
            </button>

            <p className="text-muted text-center">
              {isCreatedAccount ? (
                <>
                  Already have an account?{" "}
                  <span
                    onClick={() => setIsCreatedAccount(false)}
                    className="text-decoration-underline"
                    style={{ cursor: "pointer" }}
                  >
                    Sign In
                  </span>
                </>
              ) : (
                <>
                  Don't have an account?{" "}
                  <span
                    onClick={() => setIsCreatedAccount(true)}
                    className="text-decoration-underline"
                    style={{ cursor: "pointer" }}
                  >
                    Sign Up
                  </span>
                </>
              )}
            </p>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
