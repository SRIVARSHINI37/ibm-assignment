import { useState } from "react";
import Child from "./Child";

const Parent = () => {
    const parentData = 'Sri';
    const [childDataInParent , setChildDataInParent] = useState('');
    const receiveDataFromChild = (dataFromChild) => {
        setChildDataInParent(dataFromChild);
    };
    return(
        <>
        <h1>Parent Component</h1>
        <p>Parent data in Parent component : {parentData}</p>
        <p>Child data in parent component: {childDataInParent}</p>
        <Child childToParent={receiveDataFromChild} parentToChild={parentData} />
        </>
    )
}
export default Parent;