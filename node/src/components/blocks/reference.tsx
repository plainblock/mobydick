import { Button, Col, Row, Form, Input, Table } from "antd";
import type { ColumnsType } from "antd/es/table";
import { useMemo } from "react";

import { Identifier } from "components/constants/html";
import { Book } from "modules/hooks/model";

export function ReferenceForm(): JSX.Element {
  function onFinish(values: any) {
    console.log("Success:", values);
  }

  function onFinishFailed(errors: any) {
    console.log("Failed:", errors);
  }

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
          <Form.Item name={Identifier.title.id} label={Identifier.title.label} rules={[{ required: false }]}>
            <Input />
          </Form.Item>
        </Col>
      </Row>
      <Row gutter={30}>
        <Col span={16} key={2}>
          <Form.Item name={Identifier.author.id} label={Identifier.author.label} rules={[{ required: false }]}>
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
        <Col span={16} key={3}>
          <Form.Item name={Identifier.publisher.id} label={Identifier.publisher.label} rules={[{ required: false }]}>
            <Input />
          </Form.Item>
        </Col>
      </Row>
    </Form>
  );
}

class ReferenceTableData {
  key: number;
  title: string;
  author: string;
  publisher: string;
  publishedDate: string;
  isbn: string;

  constructor(index: number, book: Book) {
    this.key = index;
    this.title = book.title;
    this.author = book.author;
    this.publisher = book.publisher;
    this.publishedDate = book.publishedDate;
    this.isbn = book.isbn.value;
  }
}

export function ReferenceTable(props: { books: Book[] }) {
  const { books } = props;
  const data: ReferenceTableData[] = useMemo(
    () => books.map((book: Book, index: number) => new ReferenceTableData(index, book)),
    [books]
  );
  const columns: ColumnsType<ReferenceTableData> = [
    {
      key: Identifier.title.id,
      dataIndex: Identifier.title.id,
      title: Identifier.title.label,
    },
    {
      key: Identifier.author.id,
      dataIndex: Identifier.author.id,
      title: Identifier.author.label,
    },
    {
      key: Identifier.publisher.id,
      dataIndex: Identifier.publisher.id,
      title: Identifier.publisher.label,
    },
    {
      key: Identifier.publishedDate.id,
      dataIndex: Identifier.publishedDate.id,
      title: Identifier.publishedDate.label,
    },
    {
      key: Identifier.isbn.id,
      dataIndex: Identifier.isbn.id,
      title: Identifier.isbn.label,
    },
  ];
  return <Table dataSource={data} columns={columns} />;
}
