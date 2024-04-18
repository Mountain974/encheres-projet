import React, {useState} from "react";
import {useParams} from "react-router-dom";
import {Enchere} from "../fragments/Enchere.jsx";
import {useQuery} from "@tanstack/react-query";


export const Encherir = () => {
    const {noArticle} = useParams()

    const article = useQuery({
        queryKey:["article"],
        queryFn: () => fetch(`/api/articles/${noArticle}`)
            .then(response => response.json())

    })

    const retrait = useQuery({
        queryKey:["retrait"],
        queryFn: () => fetch(`/api/retraits/${noArticle}`)
            .then(response => response.json())

    })

    if (article.isPending || article.isLoading || retrait.isPending || retrait.isLoading) {
        return <div>loading</div>
    }
    if (article.error) {
        return <div>erreur : l'article n'existe pas</div>
    }
    if (retrait.error) {
        return <div>erreur : l'article n'a pas d'adresse</div>
    }

    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">Détail vente</h1>
                    </div>
                </div>
            </div>

            <div className="container mt-5">
            <Enchere isEncherir article={article.data} retrait={retrait.data}/>
            </div>
        </>
    )
}

