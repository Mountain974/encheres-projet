import React, {useEffect, useState} from 'react'
import './App.css'
import {useQuery} from "@tanstack/react-query";

function Hello() {

    const [hello, setHello] =useState([])
    useEffect(() => {
            fetch("./api/hello")
                .then(response => response.text())
                .then(data => setHello(data))
        }, []
    )


    return (
        <div >
            {hello}
        </div>
    )
}

export default Hello