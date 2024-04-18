import React from "react";
import PropTypes from "prop-types";

export const Profil = (isMonProfil, utilisateur) => {

    if (typeof utilisateur === undefined) {

    }

    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4 shadow-lg p-3 mb-5">
                    <div className="col-auto">
                        <h1 className="text-white text-center py-3">{isMonProfil ? "Mon profil" : "Profil"}</h1>
                    </div>
                </div>
            </div>

            <div className="container mt-5">
                <div className="row d-flex justify-content-center">
                    <div className="col-md-7 offset-md-5 mx-auto">

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                <p><strong>Pseudo : </strong></p>
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.pseudo}
                            </div>
                        </div>


                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                <p><strong>Nom : </strong></p>
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.nom}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                <p><strong>Prénom : </strong></p>
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.prenom}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                <p><strong>Email : </strong></p>
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.email}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                <p><strong>Téléphone : </strong></p>
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.telephone}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                <p><strong>Rue : </strong></p>
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.rue}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                <p><strong>Code postal : </strong></p>
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.codePostal}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                <p><strong>Ville : </strong></p>
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.ville}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

Profil.PropTypes = ({
    isMonProfil: PropTypes.bool,
    utilisateur: PropTypes.shape({})
})

Profil.defaultProps = {
    isMonProfil : false,
    utilisateur: undefined,
}