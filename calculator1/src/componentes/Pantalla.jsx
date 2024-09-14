import PropTypes from 'prop-types';
import './Pantalla.css';

const Pantalla = ({ input }) => {
  return (
    <div className="pantalla">
      {input}
    </div>
  );
};

Pantalla.propTypes = {
  input: PropTypes.string.isRequired,
};

export default Pantalla;
