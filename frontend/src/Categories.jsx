import { useState, useEffect } from 'react'
import './App.css'
import {useQuery} from "@tanstack/react-query";

function Categories() {

    const [listCategories, setListCategories] = useState([])

    useEffect(() => {
        fetch("./api/categories")
            .then(response => response.json())
            .then(data => setListCategories(data));
    }, [])

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
                {listCategories.map((categorie, index) => <li key={index}>{categorie.libelle}</li>)}
                {cat.data.map((categorie, index) => <li key={index}>{categorie.libelle}</li>)}
            </ul>


        </div>
    )
}

export default Categories