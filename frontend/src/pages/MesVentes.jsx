import React from 'react'
import '../App.css'
import {useQuery} from "@tanstack/react-query";
import {Encheres} from "../fragments/Encheres.jsx";


function MesVentes() {

    const mesArticles = useQuery({
        queryKey:["articles"],
        queryFn: () => fetch("./api/mesArticles")
            .then(response => response.json())
    })

    if (mesArticles.isPending || mesArticles.isLoading) {
        return <div>loading</div>
    }
    if (mesArticles.error) {
        return <div>error</div>
    }

    return (
        <>
            <Encheres articles={mesArticles} isConnected={isConnected}/>
        </>
    )
}

export default MesVentes