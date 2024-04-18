import React, { useState } from "react";
import PropTypes from "prop-types";
import {useQuery} from "@tanstack/react-query";
import {useParams} from "react-router-dom";


export const Enchere = ({isEncherir, isDetailMaVente, isAcquerir, article, retrait}) => {
    const {noArticle} = useParams()
    const [enchere, setEnchere] = useState({}); // État local pour stocker la valeur de l'enchère

    const enchereData = {
        dateEnchere: "2024-04-16",
        montantEnchere: enchere,
        utilisateur: { // Les détails de l'utilisateur effectuant l'enchère
            noUtilisateur: 1,
            pseudo: "john_doe",
            nom: "Doe",
            prenom: "John",
            email: "john.doe@example.com",
            telephone: "0123456789",
            rue: "Rue de la République",
            codePostal: "75001",
            ville: "Paris",
            motDePasse: "motdepasse123",
            credit: 100,
            administrateur: false
        },
        article: { // Les détails de l'article sur lequel l'enchère est faite
            noArticle: article.noArticle,
            nom: article.nom,
            description: article.description,
            dateDebutEncheres: article.dateDebutEncheres,
            dateFinEncheres: article.dateFinEncheres,
            miseAPrix: article.miseAPrix,
            prixVente: article.prixVente,
            vendeur: { // Les détails du vendeur de l'article
                noUtilisateur: article.vendeur.noUtilisateur,
                pseudo: article.vendeur.pseudo,
                nom: article.vendeur.nom,
                prenom: article.vendeur.prenom,
                email: article.vendeur.email,
                telephone: article.vendeur.telephone,
                rue: article.vendeur.rue,
                codePostal: article.vendeur.codePostal,
                ville: article.vendeur.ville,
                motDePasse: article.vendeur.motDePasse,
                credit: article.vendeur.credit,
                administrateur: article.vendeur.administrateur
            },
            acheteur: null,
            categorie: { // Les détails de la catégorie de l'article
                noCategorie: 1,
                libelle: "Livres"
            }
        }
    };

    // Fonction de gestion d'événement pour mettre à jour l'état local lorsque l'utilisateur modifie la valeur
    const handleChange = (event) => {
        setEnchere(event.target.value);
    };

    // Fonction de soumission du formulaire
    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            // Construire l'objet de données à envoyer dans la requête POST
            const data = {
                montantEnchere: enchere
            };

            // Envoyer la requête POST à l'URL spécifiée
            const response = await fetch(`http://localhost:8080/api/encheres`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(enchereData)
            });

            if (response.ok) {
                console.error("Enchere validée");
            } else {
                // Gérer les erreurs en cas d'échec de la requête
                console.error("Erreur lors de la soumission de l'enchère :", response.statusText);
            }
        } catch (error) {
            console.error("Erreur lors de la soumission de l'enchère :", error);
        }
    };

    const meilleureEnchere = useQuery({
        queryKey:["enchere"],
        queryFn: () => fetch(`/api/encheres/enchere/${noArticle}`)
            .then(response => response.json())

    })



    if (meilleureEnchere.isPending || meilleureEnchere.isLoading) {
        return <div>loading</div>
    }

return (

    <form className="d-none d-md-block" onSubmit={handleSubmit}>
        <div className="row mx-auto mb-4">

            <div className="col-5 mb-3 d-flex justify-content-center">
                <img className="w-75" style={{height: "100px"}}  alt="description de l'image"/>
            </div>

            <div className="col-md-7 mb-4 d-flex justify-content-center align-items-center">
                <div className="row form-group d-flex justify-content-center">

                    <div className="row d-flex align-items-center mb-3 p-0">
                        <h2>{article.nom}</h2>
                    </div>

                    <div className="row mb-3 p-0">
                        <div className="col-4">
                            <label className="fs-5">Description :</label>
                        </div>
                        <div className="col-8">
                            <p className="fs-5" style={{ height: "4rem", width: "50rem" }}>{article.description}</p>
                        </div>
                    </div>


                    {isEncherir &&
                        <div className="row mb-3 p-0">
                            <div className="col-4">
                                <label className="fs-5">Catégorie :</label>
                            </div>
                            <div className="col-8">
                                <p className="fs-5">{article.categorie.libelle}</p>
                            </div>
                        </div>
                    }

                    <div className="row mb-3 p-0">
                        <div className="col-4">
                            <label className="fs-5">Meilleure offre :</label>
                        </div>
                        <div className="col-8">
                            {meilleureEnchere.data.montantEnchere > 0 && <p style={{display: "inline"}} className="fs-5">{`${meilleureEnchere?.data.montantEnchere} pts par ${meilleureEnchere?.data.utilisateur.pseudo}`}</p>}
                            {meilleureEnchere.data.error && <p style={{display: "inline"}} className="fs-5">Pas d'enchères</p>  }
                        </div>
                    </div>

                    <div className="row mb-3 p-0">
                        <div className="col-4">
                            <label className="fs-5">Mise à prix :</label>
                        </div>
                        <div className="col-8">
                            <p className="fs-5">{article.miseAPrix}</p>
                        </div>
                    </div>

                    {(isEncherir || isDetailMaVente) &&
                        <div className="row mb-3 p-0">
                            <div className="col-4">
                                <label className="fs-5">Fin de l'enchère :</label>
                            </div>
                            <div className="col-8">
                                <p className="fs-5">{article.dateFinEnchere}</p>
                            </div>
                        </div>
                    }


                    <div className="row mb-3 p-0">
                        <div className="col-4">
                            <label className="fs-5">Retrait :</label>
                        </div>
                        <div className="col-8">
                            <p className="fs-5">{retrait.rue}</p>
                            <p className="fs-5">{retrait.codePostal}</p>
                            <p className="fs-5">{retrait.ville}</p>
                        </div>
                    </div>


                    <div className="row mb-3 p-0">
                        <div className="col-4">
                            <label className="fs-5">Vendeur :</label>
                        </div>
                        <div className="col-8">
                            <p className="fs-5">{article.vendeur.pseudo}</p>
                        </div>
                    </div>

                    {isAcquerir &&
                        <div className="row mb-3 p-0">
                            <div className="col-4">
                                <label className="fs-5">Tel :</label>
                            </div>
                            <div className="col-8">
                                <p className="fs-5">{article.vendeur.telephone}</p>
                            </div>
                        </div>
                    }

                    {isEncherir &&
                        <div className="row mb-3 p-0">
                            <div className="col-4">
                                <label className="fs-5">Ma proposition :</label>
                            </div>
                            <div className="col-3 d-flex align-items-center">
                                <input id="prix" type="number" className="form-control" style={{height: "50px"}} name="prix"
                                       required autoComplete="prix" min={
                                          meilleureEnchere ? meilleureEnchere.data.montantEnchere : article.miseAPrix}
                                          value={enchere.montantEnchere} onChange={handleChange}/>
                            </div>
                            <div className="col-5">
                                <button type="submit" className="btn btn-secondary btn-lg w-75">Enchérir</button>
                            </div>
                        </div>
                    }

                    <div className="row mt-4">
                        {(isDetailMaVente || isAcquerir) &&
                            <div className="col-6 form-group pb-3 mb-4 d-flex justify-content-end">
                                <button type="submit" className="btn btn-secondary btn_confirm btn-lg button">
                                    Retrait effectué
                                </button>
                            </div>
                        }

                        {isDetailMaVente &&
                            <>
                                <div
                                    className="col-4 px-2 form-group text-center d-flex align-items-center justify-content-center">
                                    <button type="submit" className="btn btn-secondary btn-md button">
                                        Contacter pseudo vendeur
                                    </button>
                                </div>
                                <div
                                    className="col-4 px-2 form-group text-center d-flex align-items-center justify-content-center">
                                    <a href="/"
                                       className="btn btn-secondary btn_supp d-flex align-items-center justify-content-center"
                                       style={{width: "220px", height: "60px"}}>
                                        Annuler
                                    </a>
                                </div>
                            </>
                        }

                        {(isDetailMaVente || isEncherir) &&
                            <div className="col-6 form-group mb-4 d-flex justify-content-start">
                                <a href="/"
                                   className="btn btn-secondary btn-lg d-flex align-items-center justify-content-center"
                                   style={{width: "220px", height: "60px"}}>Retour</a>
                            </div>
                        }
                    </div>
                </div>
            </div>
        </div>
    </form>
)
}

Enchere.propTypes = {
    isEncherir: PropTypes.bool,
    isDetailMaVente: PropTypes.bool,
    isAcquerir: PropTypes.bool,
    article: PropTypes.object.isRequired,
}

Enchere.defaultProps = {
    isEncherir: false,
    isDetailMaVente: false,
    isAcquerir: false,

}