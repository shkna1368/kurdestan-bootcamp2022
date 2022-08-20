import react from 'react'; 
import {useState} from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const List =(props) => {
    const [data,setData] = useState([])
    const navigate = useNavigate();

    const fetchData = () => {
        console.log('im clicked')
        axios.get('http://localhost:3005/data').then((res) => setData(res.data))
      } 

    const rowClick = (id) => {
      navigate(`/user/${id}`)
    }
    return (
    <div className='List-Main-Div'> 
               <button onClick={fetchData} className='List-Fetch-Button'>fetch</button>    
         {
        data.map((element,index) => 
        <div className='dataRow' key={index} onClick={() => rowClick(element.id)}><p>{element.name}</p><p>{element.family}</p><p>{element.isMarried}</p><p>{element.gender}</p></div>
        )
       }
    </div>
    )
}


export default List;