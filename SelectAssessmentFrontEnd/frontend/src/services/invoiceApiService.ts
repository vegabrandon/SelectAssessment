import axios from "axios";

const url = "http://localhost:8080/invoices/Invoice";

export const approveInvoice = (invoiceId: string) => {
    return axios.put(`${url}/${invoiceId}/approve`);
}