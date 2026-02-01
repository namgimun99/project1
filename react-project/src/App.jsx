import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { useEffect, useState } from 'react';
import axios from 'axios';
import Login from './Login';
import Home from './Home';

function App() {

     const [user, setUser] = useState(null);

      useEffect(() => {
        axios.get('http://localhost:8080/userInfo', {
          withCredentials: true
        })
        .then(res => {
          setUser(res.data);
        })
        .catch(err => {
          console.error("사용자 정보 조회 실패", err);
        });
      }, []);

  return (
    <Router>
      <div style={{ padding: '20px' }}>
        <h1>Spring Boot, React 연동</h1>
        <nav>
           <header style={{
                   display: 'flex',
                   justifyContent: 'space-between',
                   alignItems: 'center',
                   }}>
                   <h2>Project Main</h2>

               <div>
                 {user ? (
                   <span>👤 {user} 님</span>
                 ) : (
                   <span>로그인 정보 불러오는 중...</span>
                 )}
               </div>
             </header>
        </nav>
        <hr />

        <Routes>
          <Route path="/login" element={<Login/>} />
          <Route path="/home" element={<Home/>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;