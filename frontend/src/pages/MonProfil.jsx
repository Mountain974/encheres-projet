import React, {useState} from "react";
import {Profil} from "../fragments/Profil.jsx";
import {useQuery} from "@tanstack/react-query";

export const MonProfil = () => {

    // TODO : modifié le fetch
    const utilisateur = useQuery({
        queryKey:["utilisateur"],
        queryFn: () => fetch("./api/utilisateur")
            .then(response => response.json())
    })

    if (utilisateur.isPending || utilisateur.isLoading) {
        return <div>loading</div>
    }
    if (utilisateur.error) {
        return <div>error</div>
    }

    return (
        <>
            <Profil isMonProfil utilisateur={utilisateur}/>
            <div className="row d-flex justify-content-center mb-4">
                <button type="button" className="btn btn-secondary btn-lg button">
                    Modifier
                </button>
            </div>
        </>
    )
}