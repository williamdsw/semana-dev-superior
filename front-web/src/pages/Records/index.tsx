import React, { useEffect, useState } from 'react';
import axios from 'axios';

import { RecordsResponse } from './types';
import { formatDate } from './helpers';

import './styles.css';

import Pagination from './Pagination';
import Filters from '../Filters';

const BASE_URL = 'https://semana-dev-superior-backend.herokuapp.com';

const Records = () => {

    const [ recordsResponse, setRecordsResponse ] = useState<RecordsResponse>();
    const [ activePage, setActivePage ] = useState(0);

    console.log('recordsResponse', recordsResponse);

    useEffect(() => {
        console.log('Initialized Component: Records');

        axios.get(`${BASE_URL}/records?linesPerPage=12&page=${activePage}`).then (response => {
            console.log('response', response);
            setRecordsResponse(response.data);
        });
        
    }, [activePage]);

    const handlePageChange = (index: number) => {
        setActivePage(index);
    };

    return (
        <div className="page-container">
            <Filters link="/charts" linkText="VER GRÁFICOS" />
            <table className="records-table" cellPadding="0" cellSpacing="0">
                <thead>
                    <tr>
                        <th> INSTANTE </th>
                        <th> NOME </th>
                        <th> IDADE </th>
                        <th> PLATAFORMA </th>
                        <th> GÊNERO </th>
                        <th> TITULO DO GAME </th>
                    </tr>
                </thead>
                <tbody>
                    {recordsResponse?.content.map (record => (
                        <tr key={record.id}>
                            <td> { formatDate (record.moment) } </td>
                            <td> { record.name } </td>
                            <td> { record.age } </td>
                            <td className="text-secondary"> { record?.gameDto?.platform } </td>
                            <td> { record?.genreDto?.name } </td>
                            <td className="text-primary"> { record?.gameDto?.title } </td>
                        </tr>
                    ))}
                </tbody>
            </table>

            <Pagination 
                totalPages={recordsResponse?.totalPages} 
                activePage={activePage} 
                goToPage={handlePageChange} />
        </div>
    )
};

export default Records;