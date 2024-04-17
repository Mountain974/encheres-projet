import React, {useEffect} from 'react'

const Layout = ({ title, header, main }) => {

   useEffect(() => {
        document.title = title;
    }, []);

    return (
        <div>
        {header}
        {main}
        </div>
    )
}
export default Layout;