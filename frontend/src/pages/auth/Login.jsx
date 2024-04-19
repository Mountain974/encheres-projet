import { useState } from "react";
import { useNavigate } from "react-router-dom";

export const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigateTo = useNavigate();

  const handleLogin = async ({ username, password }) => {
    try {
      const response = await fetch("/api/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ username, password }),
      });

      if (response.ok) {
        console.log("Utilisateur connecté !");
        navigateTo("/");
      } else {
        console.error("Erreur lors de la connexion !");
      }
    } catch (error) {
      console.error("Erreur lors de la connexion :", error);
    }
  };

  return (
    <div className="container-fluid">
      <div className="row title d-flex justify-content-center mb-4">
        <div className="col-auto mt-5">
          <h1 className="text-white text-center py-3">Connexion</h1>
        </div>
      </div>

      <div className="row d-flex justify-content-center mt-5">
        <div className="col-md-5 offset-md-7 mx-auto">
          <form onSubmit={handleLogin}>
            <div className="row form-group pb-4 mx-auto d-flex align-items-center">
              <div className="col-4 offset-8 mx-auto text-md-end">
                <label htmlFor="username" className="fs-4">
                  Identifiant
                </label>
              </div>
              <div className="col-7 offest-5 mx-auto">
                <input
                  id="username"
                  type="text"
                  className="form-control fs-5"
                  name="username"
                  required
                  autoComplete="username"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  autoFocus
                />
              </div>
            </div>

            <div className="row form-group pb-4 mx-auto d-flex align-items-center">
              <div className="col-4 offset-8 mx-auto text-md-end">
                <label htmlFor="password" className="fs-4">
                  Mot de passe
                </label>
              </div>

              <div className="col-7 offest-5 mx-auto">
                <input
                  id="password"
                  type="password"
                  className="form-control"
                  name="password"
                  required
                  autoComplete="current-password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
              </div>
            </div>

            <div className="row d-flex align-items-center mx-auto my-5">
              <div className="col-5 offset-7 mx-auto d-flex justify-content-end">
                <button
                  type="submit"
                  className="btn btn-secondary btn-lg button"
                >
                  Connexion
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
