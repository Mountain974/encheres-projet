import React from "react";
import {useQuery} from "@tanstack/react-query";
import PropTypes from "prop-types";


export const Article = ({vendeur, article, isExist}) => {
    const categorie = useQuery({
        queryKey:["categories"],
        queryFn: () => fetch("./api/categories")
            .then(response => response.json())
    })

    if (categorie.isPending || cat.isLoading) {
        return <div>loading</div>
    }
    if (categorie.error) {
        return <div>error</div>
    }

    return (
        <div className="container mt-5">
        <form className="d-none d-md-block">
            <div className="row mx-auto mb-4">

                <div className="col-5 mb-3 d-flex justify-content-center">
                    <img className="w-75" style={{height: "200px"}}  alt={`photo de : ${article.nom}`}/>
                </div>

                <div className="col-md-7 mb-4 d-flex justify-content-center align-items-center">
                    <div className="row form-group d-flex justify-content-center">

                        <div className="row d-flex align-items-center mb-3 p-0">
                            <div className="col-4">
                                <label htmlFor="article" className="fs-5">Article :</label>
                            </div>
                            <div className="col-8">
                                <input id="article" type="text" className="form-control fs-5" name="article" required autoComplete="article" value="nom" autofocus />
                            </div>
                        </div>

                        <div className="row mb-3 p-0">
                            <div className="col-4">
                                <label htmlFor="description" className="fs-5">Description :</label>
                            </div>
                            <div className="col-8">
                                <textarea id="description" className="form-control fs-5" style={{resize: "none", overflowY: "auto", height: "4rem", width: "50rem"}}
                                          name="description" required autoComplete="description" value="description"></textarea>
                            </div>
                        </div>

                        <div className="row d-flex align-items-center mb-3 p-0">
                            <div className="col-4">
                                <label className="fs-5">Catégorie :</label>
                            </div>
                            <div className="col-8">
                                <select value="categorie" className="dropdown w-100">
                                    {categorie.data.map((cat, index) => <option key={index} value={cat.libelle}>{cat.libelle}</option>)}
                                </select>
                            </div>
                        </div>

                        <div className="row d-flex align-items-center mb-3 p-0">
                            <div className="col-4">
                                <label className="fs-5">Photo de l'article :</label>
                            </div>
                            <div className="col-8 d-flex justify-content-start">
                                <a href="/chemin/vers/votre/fichier.pdf" download>
                                    <button className="form-control btn btn-primary" style={{width: "235px"}}>Télécharger</button>
                                </a>
                            </div>
                        </div>

                        <div className="row d-flex align-items-center mb-3 p-0">
                            <div className="col-4">
                                <label htmlFor="prix" className="fs-5">Mise à prix :</label>
                            </div>
                            <div className="col-8">
                                <input id="prix" type="number" className="form-control fs-5 w-25" name="prix" value="miseAPrix" required autoComplete="prix" min="0" />
                            </div>
                        </div>

                        <div className="row d-flex align-items-center mb-3 p-0">
                            <div className="col-4">
                                <label htmlFor="dateDebutEnchere" className="fs-5">Début de l'enchère :</label>
                            </div>
                            <div className="col-8">
                                <input className="form-control fs-5" type="date" id="dateDebutEnchere" value="dateDebutEnchere"
                                       name="dateDebutEnchere" pattern="\d{4}-\d{2}-\d{2}" min="2024-04-18" />
                            </div>
                        </div>

                        <div className="row d-flex align-items-center mb-3 p-0">
                            <div className="col-4">
                                <label htmlFor="dateFinEnchere" className="fs-5">Fin de l'enchère :</label>
                            </div>
                            <div className="col-8">
                                <input className="form-control fs-5" type="date" id="dateFinEnchere" value="dateFinEnchere"
                                       name="dateFinEnchere" pattern="\d{4}-\d{2}-\d{2}" min="2024-04-18" />
                            </div>
                        </div>

                        <div className="row d-flex align-items-center mb-3">
                            <fieldset className="border">
                                <legend className="fs-5 ps-4">Retrait</legend>
                                <div className="row d-flex align-items-center mb-3">
                                    <div className="col-4">
                                        <label className="fs-5 ps-4">Rue :</label>
                                    </div>
                                    <div className="col-8 d-flex justify-content-start">
                                        <input className="form-control fs-5" type="string" id="rue" value={vendeur.rue} name="rue" />
                                    </div>
                                </div>

                                <div className="row d-flex align-items-center mb-3">
                                    <div className="col-4">
                                        <label className="fs-5 ps-4">Code postal :</label>
                                    </div>
                                    <div className="col-8 d-flex justify-content-start">
                                        <input className="form-control fs-5" type="string" id="codePostal" value={vendeur.codePostal} name="codePostal"/>
                                    </div>
                                </div>

                                <div className="row d-flex align-items-center mb-3">
                                    <div className="col-4">
                                        <label htmlFor="ville" className="fs-5 ps-4">Ville :</label>
                                    </div>
                                    <div className="col-8 d-flex justify-content-start">
                                        <input className="form-control fs-5" type="string" id="ville" value={vendeur.ville} name="ville"/>
                                    </div>
                                </div>
                            </fieldset>
                        </div>

                        <div className="row mt-4">
                            <div className="col-6 form-group pb-3 mb-4 d-flex justify-content-end">
                                <button type="submit" className="btn btn-secondary btn-lg button">Enregistrer</button>
                            </div>

                            <div className="col-6 form-group pb-3 mb-4 d-flex justify-content-start">
                                <a href="/" className="btn btn-secondary btn-lg button">Annuler</a>
                            </div>
                            {isExist &&
                            <div className="col-4 px-2 form-group text-center d-flex align-items-center justify-content-center">
                                <a href="/"
                                   className="btn btn-secondary btn_supp d-flex align-items-center justify-content-center button">
                                    Annuler la vente
                                </a>
                            </div>}
                        </div>
                    </div>
                </div>
            </div>
        </form>
        </div>
    )
}

Article.propTypes = ({
    vendeur: PropTypes.shape({
        rue: PropTypes.string,
        codePostal: PropTypes.string,
        ville: PropTypes.string
    }),
    article: PropTypes.shape({
        nom: PropTypes.string,
        description: PropTypes.string,
        categorie: PropTypes.shape({}),
        dateDebutEnchere: PropTypes.instanceOf(Date),
        dateFinEnchere: PropTypes.instanceOf(Date),
    }),
    isExist: PropTypes.bool
})

Article.defaultProps = {
    vendeur: {},
    article: {},
    isExist: false,
}