import React, {useEffect, useState} from 'react'
import './App.css'
import {useQuery} from "@tanstack/react-query";

function Home() {

    const [cate, setCate] =useState([   ])
    useEffect(() => {
        fetch("./api/categories")
            .then(response => response.json())
            .then(data => setCate(data))
        }, []
    )
    const cat = useQuery({
        queryKey:["categories"],
        queryFn: () => fetch("./api/categories")
            .then(response => response.json())
    })

    if (cat.isPending || cat.isLoading) {
        return <div>loading</div>
    }
    if (cat.error) {
        return <div>error</div>
    }

    return (
        <div className="App">
            <ul>
                {cate.map((categorie, index) => <li key={index}>{categorie.libelle}</li>)}
                {cat.data.map((categorie, index) => <li key={index}>{categorie.libelle}</li>)}
            </ul>


        </div>
    )
}

export default Home