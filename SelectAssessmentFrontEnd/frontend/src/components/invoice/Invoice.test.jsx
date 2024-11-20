import { render, screen } from '@testing-library/react';
import Invoice from './Invoice';

const testInvoice = {
    "invoice_number": "12345",
    "total": "199.99",
    "currency": "USD",
    "invoice_date": "2019-08-17",
    "due_date": "2019-09-17",
    "vendor_name": "Acme Trucking Inc.",
    "remittance_address": "123 ABC St. Charlotte, NC 28209"
};

test("Invoice Component renders successfully", () => {
    render(<Invoice invoice={testInvoice} />);
    const el = screen.getByText(/199.99/);
    expect(el).toBeInTheDocument();
})