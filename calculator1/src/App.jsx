import  { useState } from 'react'; // Asegúrate de incluir esta línea
import './App.css';
import Pantalla from './componentes/Pantalla';
import Botones from './componentes/Botones';
// @jsxImportSource react


function App() {
  const [input, setInput] = useState(''); // Estado para manejar los valores de la pantalla

  return (
    <div className="App">
      <div className="calculadora">
        <Pantalla input={input} />
        <Botones setInput={setInput} input={input} />
      </div>
    </div>
  );
}

export default App;
