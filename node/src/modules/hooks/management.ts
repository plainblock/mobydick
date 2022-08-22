import { useState } from "react";

import { Book, BookStatus } from "modules/hooks/model";
import { filterBooks } from "modules/sqlite/client";

export function useManagement() {
  const [list, setList] = useState<Book[]>();

  async function readManagementData(condition: { title?: string; author?: string; status?: BookStatus }) {
    const response = await filterBooks(condition);
    setList(response);
  }

  return { list, readManagementData };
}
