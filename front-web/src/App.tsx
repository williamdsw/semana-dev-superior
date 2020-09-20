import React from 'react';
import './App.css';
import Header from './components/Header';
import Home from './pages/home';

// JSX - Writing HTML tags within JS Script
function App() {
  return (
    <div>
      <Header/>
      <Home />
    </div>
  );
}

export default App;
