import { useState } from 'react';
import axios from 'axios';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e) => {
    e.preventDefault(); // 폼 제출 시 페이지 새로고침 방지

    // 스프링 시큐리티는 기본적으로 x-www-form-urlencoded 형식을 기대합니다.
    const formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);

    axios.post('http://localhost:8080/login', formData, {
      withCredentials: true // 세션 쿠키를 받아오기 위해 필수!
    })
    .then(res => {
        alert("로그인 성공!");
        window.location.href = "/home";    })
    .catch(err => {
        alert("로그인 실패: 아이디 또는 비밀번호를 확인하세요.");
    });
  };

  return (
    <div style={{ maxWidth: '300px', margin: '50px auto' }}>
      <h2>로그인</h2>
      <form onSubmit={handleLogin}>
        <input
          type="text"
          placeholder="아이디"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          style={{ display: 'block', width: '100%', marginBottom: '10px' }}
        />
        <input
          type="password"
          placeholder="비밀번호"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          style={{ display: 'block', width: '100%', marginBottom: '10px' }}
        />
        <button type="submit" style={{ width: '100%' }}>로그인</button>
      </form>
    </div>
  );
}

export default Login;