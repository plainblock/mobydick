import { Button, Col, Form, Input, Row, Select, Table } from "antd";
import { Option } from "antd/es/mentions";

import { Identifier } from "components/constants/html";

export function ManagementForm(): JSX.Element {
  function onFinish(value: any) {}

  function onFinishFailed(errors: any) {}

  return (
    <Form
      name="search"
      labelCol={{ span: 6 }}
      wrapperCol={{ span: 30 }}
      initialValues={{ remember: true }}
      onFinish={onFinish}
      onFinishFailed={onFinishFailed}
      autoComplete="off"
    >
      <Row gutter={30}>
        <Col span={16} key={1}>
          <Form.Item name={Identifier.status.id} label={Identifier.status.label} rules={[{ required: false }]}>
            <Select defaultValue="9">
              <Option value="9">すべて</Option>
              <Option value="0">未購入</Option>
              <Option value="1">積読</Option>
              <Option value="2">既読</Option>
            </Select>
          </Form.Item>
        </Col>
      </Row>
      <Row gutter={30}>
        <Col span={16} key={1}>
          <Form.Item name={Identifier.title.id} label={Identifier.title.label} rules={[{ required: false }]}>
            <Input />
          </Form.Item>
        </Col>
        <Col span={8} key={10}>
          <Form.Item>
            <Button type="primary" htmlType="submit">
              検索
            </Button>
          </Form.Item>
        </Col>
      </Row>
      <Row gutter={30}>
        <Col span={16} key={2}>
          <Form.Item name={Identifier.author.id} label={Identifier.author.label} rules={[{ required: false }]}>
            <Input />
          </Form.Item>
        </Col>
      </Row>
    </Form>
  );
}
