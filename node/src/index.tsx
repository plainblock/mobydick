import React from 'react';
import ReactDOM from 'react-dom/client';

import reportWebVitals from 'modules/utils/reportWebVitals';
import App from 'views/App';

import 'assets/css/index.css';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
reportWebVitals();
