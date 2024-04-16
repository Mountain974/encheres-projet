import React from "react";
import PropTypes from "prop-types";

export const Profil = (isMonProfil, utilisateur) => {

    if (typeof utilisateur === undefined) {

    }

    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">{isMonProfil ? "Mon profil" : "Profil"}</h1>
                    </div>
                </div>
            </div>

            <div className="container mt-5">
                <div className="row d-flex justify-content-center">
                    <div className="col-md-5 offset-md-7 mx-auto">

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Pseudo :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.pseudo}
                            </div>
                        </div>


                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Nom :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.nom}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Prénom :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.prenom}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Email :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.email}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Téléphone :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.telephone}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Rue :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.rue}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Code postal :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.codePostal}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Ville :
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