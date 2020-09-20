import React, { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import axios from 'axios';

import Filters from '../Filters';

import { barOptions, pieOptions } from './chart-options';
import { buildBarSeries, getPlatformChartData, getGenderChartData } from './helpers';

import './styles.css';

const BASE_URL = 'http://localhost:8080'

type PieChartData = {
    labels: string[];
    series: number[];
};

type BarChartData = {
    x: string;
    y: number;
};

const initialPieData = {
    labels: [], series: []
};

const Charts = () => {

    const [gamesData, setGamesData] = useState<BarChartData[]>([]);
    const [platformData, setPlatformData] = useState<PieChartData>(initialPieData);
    const [genderData, setGenderData] = useState<PieChartData>(initialPieData);

    useEffect(() => {
        console.log('Charts Initiated!');

        async function getData () {
            const recordsReponse = await axios.get(`${BASE_URL}/records`);
            const gamesReponse = await axios.get(`${BASE_URL}/games`);

            console.log('recordsReponse.data', recordsReponse.data);
            console.log('gamesReponse.data', gamesReponse.data);

            const barData = buildBarSeries(gamesReponse.data, recordsReponse.data.content);
            const platformChartData = getPlatformChartData(recordsReponse.data.content);
            const genderChartData = getGenderChartData(recordsReponse.data.content);

            setGamesData(barData);
            setPlatformData(platformChartData);
            setGenderData(genderChartData);
        }

        getData();

    }, []);

    return (
        <div className="page-container">
            <Filters link="/records" linkText="VER TABELA"/>
            <div className="chart-container">
                <div className="top-related">
                    <h1 className="top-related-title">
                        Jogos mais votados
                    </h1>
                    <div className="games-container">
                        <Chart type="bar" width="500" height="500" options={barOptions} series={[{ data: gamesData }]}  />
                    </div>
                </div>
                <div className="charts">
                    <div className="platform-chart">
                        <h2 className="chart-title"> Plataformas </h2>
                        <Chart type="donut" 
                               options={{ ...pieOptions, labels: platformData?.labels}}
                               series={platformData?.series}
                               width="350" />
                    </div>
                    <div className="gender-chart">
                        <h2 className="chart-title"> Gêneros </h2>
                        <Chart type="donut" 
                               options={{ ...pieOptions, labels: genderData?.labels}}
                               series={genderData?.series}
                               width="350" />
                    </div>
                </div>
            </div>
        </div>
    )
};

export default Charts;