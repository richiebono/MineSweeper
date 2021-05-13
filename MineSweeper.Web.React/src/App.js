import React from "react";
import "./App.css";
import Board from "./components/Board";

function App() {
  return (
    <div className="App">
      <h1 style={{ fontFamily: "Fredoka One" }}>Bono Minesweeper</h1>
      <Board />
    </div>
  );
}

export default App;
