import React from 'react';
import ReactDOM from 'react-dom/client';

import reportWebVitals from 'modules/utils/reportWebVitals';
import ReferenceView from "views/reference";

import 'assets/css/index.css';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <ReferenceView />
  </React.StrictMode>
);
reportWebVitals();
