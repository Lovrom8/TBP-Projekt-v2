import styled from 'styled-components';
import { colors } from '../../lib/style/theme';

export const RecommendationWrapper = styled.div`
    display: flex;
    justify-content: center;
    padding-top: 20px;
    padding-left: 150px;
`;

export const RecommendationGrid = styled.div`
    display:grid;
    grid-column-gap: 50px;
    
    grid-template-columns: 1fr 1fr 1fr 1fr;
    margin: 0 auto;
    text-align:center;
`;
