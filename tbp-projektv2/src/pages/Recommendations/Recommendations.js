import React, { useState, useEffect } from 'react';
import { getRecommendations } from '../../api/recommendation';
import Recommendation from '../../components/Recommendation/Recommendation';
import { RecommendationGrid, RecommendationWrapper } from './RecommendationsStyle';
import userContext from '../../context/userContext';

const Recommendations = () => {
    const [recommendationData, setRecommendationData] = useState(false);

    const loadRecommendations = async () => {
      const dataJSON = await getRecommendations(userContext.getJWT);
      setRecommendationData(dataJSON.data);
      console.log(dataJSON.data);
    };
  
    useEffect(() => {
      loadRecommendations();
    }, []);

    return (
        <RecommendationWrapper>
            <RecommendationGrid>
            { recommendationData &&
            recommendationData.map((recommendation) => <Recommendation key={recommendation.id} recommendedSong={recommendation} /> )  
            }
            </RecommendationGrid>
        </RecommendationWrapper>
    );
};

export default Recommendations;