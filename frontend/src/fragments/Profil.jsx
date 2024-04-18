import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {useQuery} from "@tanstack/react-query";

export const Profil = () => {

    const {pseudo} = useParams()
    console.log(pseudo)
    const utilisateur = useQuery({
        queryKey:["utilisateur"],
        queryFn: () => fetch(`/api/utilisateurs/pseudo/${pseudo}`)
            .then(response => response.json())

    })

    if (utilisateur.isPending || utilisateur.isLoading) {
        return <div>loading</div>
    }
    if (utilisateur.error) {
        return <div>erreur : l'utilisateur n'existe pas</div>
    }

    console.log(utilisateur.data)


    return (
        <>
            <div className="container-fluid">
                <div className="row title d-flex justify-content-center mb-4">
                    <div className="col-auto mt-5">
                        <h1 className="text-white text-center py-3">Profil</h1>
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
                                {utilisateur.data.pseudo}
                            </div>
                        </div>


                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Nom :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.data.nom}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Prénom :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.data.prenom}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Email :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.data.email}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Téléphone :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.data.telephone}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Rue :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.data.rue}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Code postal :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.data.codePostal}
                            </div>
                        </div>

                        <div className="row form-group pb-4 mx-auto d-flex align-items-center">
                            <div className="col-4 offset-8 mx-auto">
                                Ville :
                            </div>
                            <div className="col-7 offest-5 mx-auto">
                                {utilisateur.data.ville}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

