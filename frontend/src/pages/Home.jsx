import React from 'react'
import '../App.css'
import {useQuery, useQueryClient} from "@tanstack/react-query";
import {Encheres} from "../fragments/Encheres.jsx";


function Home(isConnected) {
    const queryClient = useQueryClient()
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
            <Encheres articles={articlesEnCours.data} retraits={retraits.data} isConnected/>
            <button className="btn btn-primary"
                    onClick={() => queryClient.invalidateQueries({queryKey: ["articles"]})}>Reload
            </button>
        </>

    )
}

export default Home