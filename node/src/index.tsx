import React from 'react';
import ReactDOM from 'react-dom/client';
import {Tabs} from 'antd';

import reportWebVitals from 'modules/utils/reportWebVitals';
import ReferenceView from "views/reference";

import 'antd/dist/antd.css';
import 'assets/css/index.css';

const { TabPane } = Tabs;
const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <Tabs defaultActiveKey="reference">
      <TabPane tab="書籍検索" key="reference">
        <ReferenceView/>
      </TabPane>
      <TabPane tab="本棚管理" key="management">

      </TabPane>
    </Tabs>
  </React.StrictMode>
);
reportWebVitals();
