import './InvoiceList.css'
import React from 'react';
import { useState, useEffect } from 'react';
import { connect, disconnect } from '../../services/webSocketService.ts';
import Invoice from '../invoice/Invoice.jsx';
import { Table, TableBody, TableCell, TableHead, TableRow } from '@mui/material';

function InvoiceList() {
    const [invoices, setInvoices] = useState([]);
    useEffect(() => {
        connect(newInvoices => setInvoices(newInvoices));
        return disconnect;
    }, []);
    return (
        <div className='invoice-list-containers rounded-2xl border border-white'>            
                <Table>
                    <TableHead>
                        <TableRow className="invoice-list-row">
                            <TableCell>
                                Invoice Number
                            </TableCell>
                            <TableCell>
                                Vendor Name
                            </TableCell>
                            <TableCell>
                                Vendor Address
                            </TableCell>
                            <TableCell>
                                Invoice Total
                            </TableCell>
                            <TableCell>
                                Invoice Date
                            </TableCell>
                            <TableCell>
                                Due Date
                            </TableCell>
                            <TableCell>
                                Approve
                            </TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                    {
                    invoices.length ? 
                        invoices.map(invoice => <Invoice invoice={invoice} key={invoice.id}/>) :
                        <TableRow className="invoice-list-row no-border">
                            <TableCell className='no-border'>No current pending invoices</TableCell>
                        </TableRow>
                    }
                    </TableBody>
                </Table>
        </div>
    );
}

export default InvoiceList;