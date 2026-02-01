import { useEffect, useState } from 'react';
import axios from 'axios';

function Home() {
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
    <div style={{ minHeight: '100vh' }}>
      <main style={{
        padding: '50px',
        textAlign: 'center'
      }}>
        <h1>메인 화면</h1>
        <p>Spring Boot + React 연동 메인 페이지입니다.</p>
      </main>
    </div>
  );
}

export default Home;