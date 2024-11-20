import { approveInvoice } from '../../services/invoiceApiService.ts';
import './Invoice.css';
import { TableRow, TableCell, Button, CircularProgress } from '@mui/material';
const Invoice = ({ invoice }) => {
    let approveLoading = false;

    const approve = (id) => {
        approveLoading = true;
        approveInvoice(id)
            .then(() => {
                approveLoading = false;
            })
            .catch(err => {
                console.error("Error received during invoice approval:", err)
            })
    }

    return <TableRow className="invoice-list-row">
        <TableCell>{invoice.invoice_number}</TableCell>
        <TableCell>{invoice.vendor_name}</TableCell>
        <TableCell>{invoice.remittance_address}</TableCell>
        <TableCell>{invoice.total}</TableCell>
        <TableCell>{invoice.invoice_date}</TableCell>
        <TableCell>{invoice.due_date}</TableCell>
        <TableCell>
            {
                approveLoading ? 
                    <CircularProgress /> :
                    <Button variant="contained" onClick={() => approve(invoice.id)}>Approve</Button>
            }
        </TableCell>
    </TableRow>
};
export default Invoice;