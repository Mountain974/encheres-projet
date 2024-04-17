import React from "react";
import {useQuery} from "@tanstack/react-query";
import {UnArticle} from "./UnArticle.jsx";
import PropTypes from "prop-types";
import {Enchere} from "./Enchere.jsx";

export const Encheres = ({articles, isConnected}) => {
    const categories = useQuery({
        queryKey:["categories"],
        queryFn: () => fetch("./api/categories")
            .then(response => response.json())
    })


    if (categories.isPending || categories.isLoading) {
        return <div>loading</div>
    }
    if (categories.error) {
        return <div>error</div>
    }

    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-2">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">Liste des enchères</h1>
                    </div>
                </div>
            </div>

            <div className="container mt-5">
                <div className="d-flex flex-row mb-3">
                    <h3 className="p-2"> Filtres :</h3>
                </div>

                <form action="/" method="get">
                    <div className="row mx-auto mb-4">
                        <div className="col-md-6 mb-4">

                            <div className="d-none d-md-block">
                                <div className="row d-flex justify-content-center mb-3">
                                    <div className="col-auto">
                                        <button type="submit" className="btn-icons"><i className="fa-solid fa-magnifying-glass fa-2x"></i></button>
                                    </div>
                                    <div className="col p-0">
                                        <input required type="text" className="form-control" placeholder="Le nom de l'article contient" value="search" name="search" id="search" />
                                    </div>
                                </div>
                            </div>

                            <div className="row d-flex align-items-center">
                                <div className="col-4">
                                    <label className="fs-5">Catégorie :</label>
                                </div>
                                <div className="col-8 p-0">
                                    <div className="col-8">
                                        <select value="categorie" className="dropdown w-100">
                                            {categories.data.map((cat, index) => <option key={index}
                                                                                        value={cat.libelle}>{cat.libelle}</option>)}
                                        </select>
                                    </div>
                                </div>
                            </div>

                        </div>
                        {isConnected &&
                        <div className="d-none d-md-block">
                            <div className="row d-flex justify-content-center my-3">

                                <div className="col-6 p-0">
                                    <div className="form-check">
                                        <input className="form-check-input" type="radio" name="formSelection"
                                               id="achatsRadio" checked onClick="selectForm('formAchats')"/>
                                        <label className="form-check-label"
                                               htmlFor="achatsRadio"><strong> Achats</strong></label>
                                    </div>

                                    <div id="formAchats" className="container mb-3">
                                           <div>
                                                <input type="checkbox" id="encheresOuvertes" name="encheresOuvertes"
                                                       value="encheresOuvertes"/>
                                                <label className="critere" htmlFor="encheresOuvertes">enchères
                                                    ouvertes</label>
                                            </div>
                                            <div>
                                                <input type="checkbox" id="encheresEnCours" name="encheresEnCours"
                                                       value="encheresEnCours"/>
                                                <label className="critere" htmlFor="encheresEnCours">mes enchères en
                                                    cours</label>
                                            </div>
                                            <div>
                                                <input type="checkbox" id="encheresRemportees"
                                                       name="encheresRemportees" value="encheresRemportees"/>
                                                <label className="critere" htmlFor="encheresRemportees">mes enchères
                                                    remportées</label>
                                            </div>
                                    </div>
                                </div>

                                <div className="col-6 p-0">
                                    <div className="form-check">
                                        <input className="form-check-input" type="radio" name="formSelection"
                                               id="ventesRadio" onClick="selectForm('formVentes')"/>
                                        <label className="form-check-label" htmlFor="ventesRadio"><strong> Mes
                                            ventes</strong></label>
                                    </div>
                                    <div id="formVentes" className="container mb-3">
                                            <div>
                                                <input type="checkbox" id="ventesEnCours" name="ventesEnCours"
                                                       value="ventesEnCours"/>
                                                <label className="critere" htmlFor="ventesEnCours">mes ventes en
                                                    cours</label>
                                            </div>
                                            <div>
                                                <input type="checkbox" id="ventesNonDebutees"
                                                       name="ventesNonDebutees" value="ventesNonDebutees"/>
                                                <label className="critere" htmlFor="ventesNonDebutees">ventes non
                                                    débutées</label>
                                            </div>
                                            <div>
                                                <input type="checkbox" id="ventesTerminees" name="ventesTerminees"
                                                       value="ventesTerminees"/>
                                                <label className="critere" htmlFor="ventesTerminees">ventes
                                                    terminées</label>
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        }
                        <div className="col-md-6 mb-4 p-0 d-flex justify-content-center align-items-center">
                            <button className="btn btn-secondary w-75 h-100" type="submit">Rechercher</button>
                        </div>
                    </div>
                </form>
                <div className="row mx-auto d-flex justify-content-between">
                    {articles.map((article, index) => <UnArticle article={article} index={index}/>)}
                </div>
            </div>
        </>
    )
}

Encheres.PropTypes= ({
    articles: PropTypes.shape({}),
    isConnected: PropTypes.bool
})

Encheres.defaultProps= {
    articles: undefined,
    isConnected: false,
}

