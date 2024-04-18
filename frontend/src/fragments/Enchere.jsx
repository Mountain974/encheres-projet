import React from "react";
import PropTypes from "prop-types";
import {useQuery} from "@tanstack/react-query";
import {useParams} from "react-router-dom";

export const Enchere = ({isEncherir, isDetailMaVente, isAcquerir, article, retrait}) => {
    const {noArticle} = useParams()
    const meilleureEnchere = useQuery({
        queryKey:["enchere"],
        queryFn: () => fetch(`/api/encheres/enchere/${noArticle}`)
            .then(response => response.json())

    })
    console.log(meilleureEnchere.data)

    if (meilleureEnchere.isPending || meilleureEnchere.isLoading) {
        return <div>loading</div>
    }

return (

    <form className="d-none d-md-block">
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
                            <p style={{display: "inline"}} className="fs-5">{`${meilleureEnchere.data.montantEnchere} pts par ${meilleureEnchere.data.utilisateur.pseudo}`}</p>
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
                                       required autoComplete="prix" min="0"/>
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