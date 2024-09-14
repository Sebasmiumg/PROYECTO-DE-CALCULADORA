import PropTypes from 'prop-types';
import './Botones.css';
import axios from 'axios';  // Importación de axios

const Botones = ({ setInput, input }) => {
  const agregarInput = (valor) => {
    const operadores = ['+', '-', '*', '/'];
    if (input.length === 0 && operadores.includes(valor)) return;
    if (operadores.includes(input.slice(-1)) && operadores.includes(valor)) return;
    setInput(input + valor);
  };

  const limpiarPantalla = () => setInput('');
  const borrarUltimo = () => setInput(input.slice(0, -1));

  const calcularResultado = async () => {
    try {
      // Eliminar cualquier espacio y asegurar que los caracteres son válidos
      const sanitizedInput = input.replace(/\s+/g, '').replace(/[^0-9+\-*/().]/g, '');
      const response = await axios.get('/api/calculadora/calcular', { params: { input: sanitizedInput } });
      setInput(response.data.toString());  // Mostramos el resultado en la pantalla
    } catch (err) {
      console.error("Error en la operación:", err.response ? err.response.data : err.message);
      setInput("Error");
    }
  };

  return (
    <div className="Botones">
      <button onClick={() => agregarInput('1')}>1</button>
      <button onClick={() => agregarInput('2')}>2</button>
      <button onClick={() => agregarInput('3')}>3</button>
      <button onClick={() => agregarInput('+')} className="operacion">+</button>
      <button onClick={() => agregarInput('4')}>4</button>
      <button onClick={() => agregarInput('5')}>5</button>
      <button onClick={() => agregarInput('6')}>6</button>
      <button onClick={() => agregarInput('-')} className="operacion">-</button>
      <button onClick={() => agregarInput('7')}>7</button>
      <button onClick={() => agregarInput('8')}>8</button>
      <button onClick={() => agregarInput('9')}>9</button>
      <button onClick={() => agregarInput('*')} className="operacion">*</button>
      <button onClick={() => agregarInput('0')} className="zero">0</button>
      <button onClick={() => limpiarPantalla()} className="operacion">C</button>
      <button onClick={() => borrarUltimo()}>←</button>
      <button onClick={() => agregarInput('/')} className="operacion">/</button>
      <button onClick={() => calcularResultado()} className="igual">=</button>
    </div>
  );
};

Botones.propTypes = {
  setInput: PropTypes.func.isRequired,
  input: PropTypes.string.isRequired,
};

export default Botones;
