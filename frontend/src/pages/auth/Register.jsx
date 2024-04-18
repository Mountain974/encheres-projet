import { useState } from "react";
import { useNavigate } from "react-router-dom";

export const Register = () => {
  const navigateTo = useNavigate();

  const [createdUser, setCreatedUser] = useState({
    pseudo: "",
    nom: "",
    prenom: "",
    email: "",
    telephone: "",
    rue: "",
    codePostal: "",
    ville: "",
    motDePasse: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCreatedUser({ ...createdUser, [name]: value });
  };

  const handleRegister = async (e) => {
    e.preventDefault();

    console.log("utilisateur à créer ", createdUser);

    try {
      const response = await fetch("/api/utilisateurs/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(createdUser),
      });

      if (response.ok) {
        console.log("Utilisateur créé");
        navigateTo('/login');
      } else {
        console.log("Response : ", response);
        const data = await response.json();
        console.log("Problème avec la réponse API ! ", data.message);
      }
    } catch (error) {
      console.log("Problème avec la requête envoyée ! ", error);
    }
  };

  return (
    <div className="row d-flex justify-content-center mt-5">
      <div className="col-md-5 offset-md-7 mx-auto">
        <form onSubmit={handleRegister}>
          <div className="row form-group mx-auto">
            <div className="col-md-5 offset-md-1 pb-4">
              <div className="row align-items-center">
                <div className="col-4">
                  <label htmlFor="pseudo" className="fs-4">
                    Pseudo :
                  </label>
                </div>
                <div className="col-8">
                  <input
                    id="pseudo"
                    type="text"
                    className="form-control fs-5"
                    name="pseudo"
                    required
                    autoComplete="pseudo"
                    autoFocus
                    value={createdUser.pseudo}
                    onChange={handleChange}
                  />
                </div>
              </div>
            </div>
            <div className="col-md-5 offset-md-1 pb-4">
              <div className="row align-items-center">
                <div className="col-4">
                  <label htmlFor="nom" className="fs-4">
                    Nom :
                  </label>
                </div>
                <div className="col-8">
                  <input
                    id="nom"
                    type="text"
                    className="form-control fs-5"
                    name="nom"
                    required
                    autoComplete="nom"
                    autoFocus
                    value={createdUser.nom}
                    onChange={handleChange}
                  />
                </div>
              </div>
            </div>
          </div>
          <div className="row form-group mx-auto">
            <div className="col-md-5 offset-md-1 pb-4">
              <div className="row align-items-center">
                <div className="col-4">
                  <label htmlFor="prenom" className="fs-4">
                    Prénom :
                  </label>
                </div>
                <div className="col-8">
                  <input
                    id="prenom"
                    type="text"
                    className="form-control fs-5"
                    name="prenom"
                    required
                    autoComplete="prenom"
                    autoFocus
                    value={createdUser.prenom}
                    onChange={handleChange}
                  />
                </div>
              </div>
            </div>
            <div className="col-md-5 offset-md-1 pb-4">
              <div className="row align-items-center">
                <div className="col-4">
                  <label htmlFor="email" className="fs-4">
                    Email :
                  </label>
                </div>
                <div className="col-8">
                  <input
                    id="email"
                    type="email"
                    className="form-control fs-5"
                    name="email"
                    required
                    autoComplete="email"
                    autoFocus
                    value={createdUser.email}
                    onChange={handleChange}
                  />
                </div>
              </div>
            </div>
          </div>
          <div className="row form-group mx-auto">
            <div className="col-md-5 offset-md-1 pb-4">
              <div className="row align-items-center">
                <div className="col-4">
                  <label htmlFor="telephone" className="fs-4">
                    Téléphone :
                  </label>
                </div>
                <div className="col-8">
                  <input
                    id="telephone"
                    type="text"
                    className="form-control fs-5"
                    name="telephone"
                    required
                    autoComplete="telephone"
                    autoFocus
                    value={createdUser.telephone}
                    onChange={handleChange}
                  />
                </div>
              </div>
            </div>
            <div className="col-md-5 offset-md-1 pb-4">
              <div className="row align-items-center">
                <div className="col-4">
                  <label htmlFor="rue" className="fs-4">
                    Rue :
                  </label>
                </div>
                <div className="col-8">
                  <input
                    id="rue"
                    type="text"
                    className="form-control fs-5"
                    name="rue"
                    required
                    autoComplete="rue"
                    autoFocus
                    value={createdUser.rue}
                    onChange={handleChange}
                  />
                </div>
              </div>
            </div>
          </div>
          <div className="row form-group mx-auto">
            <div className="col-md-5 offset-md-1 pb-4">
              <div className="row align-items-center">
                <div className="col-4">
                  <label htmlFor="codePostal" className="fs-4">
                    Code postal :
                  </label>
                </div>
                <div className="col-8">
                  <input
                    id="codePostal"
                    type="text"
                    className="form-control fs-5"
                    name="codePostal"
                    required
                    autoFocus
                    autoComplete="codePostal"
                    value={createdUser.codePostal}
                    onChange={handleChange}
                  />
                </div>
              </div>
            </div>
            <div className="col-md-5 offset-md-1 pb-4">
              <div className="row align-items-center">
                <div className="col-4">
                  <label htmlFor="ville" className="fs-4">
                    Ville :
                  </label>
                </div>
                <div className="col-8">
                  <input
                    id="ville"
                    type="text"
                    className="form-control fs-5"
                    name="ville"
                    required
                    autoComplete="ville"
                    autoFocus
                    value={createdUser.ville}
                    onChange={handleChange}
                  />
                </div>
              </div>
            </div>
          </div>
          <div className="row form-group mx-auto">
            <div className="col-md-5 offset-md-1 pb-4">
              <div className="row align-items-center">
                <div className="col-4">
                  <label htmlFor="motDePasse" className="fs-4">
                    Mot de passe
                  </label>
                </div>
                <div className="col-8">
                  <input
                    id="motDePasse"
                    type="password"
                    className="form-control fs-5"
                    name="motDePasse"
                    required
                    autoComplete="motDePasse"
                    autoFocus
                    value={createdUser.motDePasse}
                    onChange={handleChange}
                  />
                </div>
              </div>
            </div>
          </div>
          <div className="row form-group my-5 d-flex align-items-center ">
            <div className="col-4 px-2 form-group text-center d-flex align-items-center justify-content-center">
              <button
                type="submit"
                className="btn btn-secondary btn_confirm btn-md button"
              >
                Créer mon compte
              </button>
            </div>

            <div className="col-4 px-2 form-group text-center d-flex align-items-center justify-content-center">
              <a
                href="/"
                className="btn btn-secondary btn_supp d-flex align-items-center justify-content-center button"
              >
                Annuler
              </a>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
};
export default Register;
