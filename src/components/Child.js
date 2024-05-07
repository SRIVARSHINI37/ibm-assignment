const Child = (props) => {
    const parentDataInChild = props.parentToChild;
    const childData = 'varshini';

    const passDataToParent = () => {
        props.childToParent(childData);
        
    }
    return(
        <>
        <h1>Child Component</h1>
        <p>Parent data in Child component : {parentDataInChild}</p>
        <p>Child data in Child component : {childData}</p>
        <button onClick={passDataToParent}>Pass data to parent</button>
        </>
    )
}
export default Child;