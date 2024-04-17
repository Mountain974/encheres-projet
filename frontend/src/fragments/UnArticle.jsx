import React from "react";

export const UnArticle = ({article, index}) => {
    const {nom, prixInitial, classement, dateFinEnchere, retrait, vendeur} = article
    return (
        <div key={index} className="col-md-5 offset-md-1 mb-4 border border-secondary m-0">
            <div className="row align-items-center">
                <div className="col-4">
                    <div className="img">
                        <img alt="photo article" />
                    </div>
                </div>
                <div className="col-8 ps-md-3">
                    <h5 style={{textDecoration: "underline"}}>{nom}</h5>
                    <p style={{display: "inline"}}><strong>Prix : </strong></p> <p style={{display: "inline"}}>{prixInitial}</p>
                    <p style={{display: "inline"}}><strong>Classement : </strong></p> <p style={{display: "inline"}}>{classement}</p><br />
                    <p style={{display: "inline"}}><strong>Fin de l'enchère : </strong></p><p style={{display: "inline"}}>{dateFinEnchere}</p><br />
                    <p style={{display: "inline"}}><strong>Retrait : </strong></p><p style={{display: "inline"}}>{retrait.rue}<br />{`${retrait.codePostal} ${retrait.ville}`}</p><br />
                    <p style={{display: "inline"}}><strong>Vendeur : </strong></p><p style={{display: "inline"}}>{vendeur.pseudo}</p>
                </div>
            </div>
        </div>
    )
}