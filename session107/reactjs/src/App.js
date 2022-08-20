import logo from './logo.svg';
import './App.css';
import List from './components/List'
import { Routes, Route, Link } from "react-router-dom";
import Detail from './components/Detail';

function App() {

  return (
    <div className="App">
     
     <Routes>
        <Route path="/" element={<List />} />
        <Route path="/user/:id" element={<Detail userInfo ={{id:1,name:'shabab' , familyName:'koohi'}}/>} />
      </Routes>
    </div>
  );
}

export default App;
