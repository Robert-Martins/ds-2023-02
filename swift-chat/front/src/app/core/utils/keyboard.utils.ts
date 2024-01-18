export const isEnterKey = (key: string): boolean => {
    return key === 'Enter';
}

export const isSpaceKey = (key: string): boolean => {
    return key === " ";
}

export const isTabKey = (key: string): boolean => {
    return key === 'Tab';
}

export const isArrowKey = (key: string): boolean => {
    return key.includes('Arrow');
}

export const isArrowForward = (key: string): boolean => {
    return key.includes('Up') || key.includes('Right');
}

export const isArrowPrevious = (key: string): boolean => {
    return key.includes('Down') || key.includes('Left');
}