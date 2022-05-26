import React from 'react';
import styled from 'styled-components';
import '../../Font.css';

//https://projects.verou.me/bubbly/
const MessageStyle = styled.div`
        
        position: sticky;
        background: ${props => (props.isFriend ? '#a58af0' : '#51d5e1')};
        border-radius: .4em;
        padding : 10px;
        max-width : 300px;
        min-width : 100px;
        text-align: left;
        ${props => (props.isFriend ? 'float: left;' : 'float: right;')}
        font-size: 20px;
        font-family: IBMPlexSansKR-Medium;
        

        &:after {
            content: '';
            position: absolute;
            bottom: 0;
            ${props => (props.isFriend ? 'left: 30%;' : 'right: 30%;')}
            width: 0;
            height: 0;
            border: 23px solid transparent;
            border-top-color: ${props => (props.isFriend ? '#a58af0' : '#51d5e1')};
            border-bottom: 0;
            ${props => (props.isFriend ? 'border-left: 0;' : 'border-right: 0;')}
            ${props => (props.isFriend ? 'margin-left: -11.5px;' : 'margin-right: -11.5px;')}
            margin-bottom: -23px;
        }
    `;

const DivStyle = styled.div`
        display: block;
        text-align: left;
        margin: 30px;
`;
function ChatMessage(props) {

    return (
        <div className="ChatMessage">
            <DivStyle>
                {
                    props.isFriend &&
                    <div style={{ fontFamily: 'IBMPlexSansKR-Medium' }}>{props.speaker}</div>
                }
                <MessageStyle isFriend={props.isFriend}>
                    {props.message}
                </MessageStyle>
            </DivStyle>
        </div >
    );
}

export default ChatMessage;