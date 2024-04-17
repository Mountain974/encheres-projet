import React from 'react'
import '../App.css'
import {useQuery} from "@tanstack/react-query";
import {Encheres} from "../fragments/Encheres.jsx";


function Home(isConnected) {

    const articlesEnCours = useQuery({
        queryKey:["articles"],
        queryFn: () => fetch("./api/articles")
            .then(response => response.json())
    })

    const retraits = useQuery({
        queryKey:["retraits"],
        queryFn: () => fetch("./api/retraits")
            .then(response => response.json())
    })

    if (articlesEnCours.isPending || articlesEnCours.isLoading) {
        return <div>loading</div>
    }
    if (articlesEnCours.error) {
        return <div>error</div>
    }

    return (
        <>
            <Encheres articles={articlesEnCours.data} retraits={retraits.data} isConnected={isConnected}/>
        </>

    )
}

export default Home