import react from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Detail = (props) => {
    const params = useParams()
    const [detail,setDetail] = useState({})
    const navigate = useNavigate(); 
    console.log('detail',detail);

    useEffect(() => {
        axios.get(`http://localhost:3005/data/${params.id}`).then((res) => setDetail(res.data))

    },[])

const goToHome = () => {
  navigate('/')
}
    return <div className='Detail-Main-Div'>
   <button onClick={goToHome} className='List-Fetch-Button'>Home</button>
       <div className='Detail-Row'>
        <p>name:</p>
        <p>{detail?.name}</p>
        </div>
        <div className='Detail-Row'>
        <p>family:</p>
        <p>{detail?.family}</p>
        </div>
    </div>
}


 export default Detail; 